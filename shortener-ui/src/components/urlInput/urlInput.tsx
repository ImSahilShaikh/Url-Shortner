import { Button, Form, Stack } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import generateUrl from "../../api/apiCall";
import React, { useState } from "react";
import { ShortUrlResponseData } from "../../interface/shortUrlResponseData";
import DisplayShortUrl from "../DisplayUrlDetails/DisplayUrlDetails";
import "./UrlInput.css";

export default function UrlInput() {
  const [inputUrl, setInputUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputUrl(event.target.value);
  };

  const clearInput = () => {
    setInputUrl("");
  };

  const handleUrlGeneration = async () => {
    try {
      const responseData: ShortUrlResponseData | undefined = await generateUrl(
        inputUrl
      );
      if (responseData) {
        setShortUrl(responseData.shortenedUrl);
      } else {
        throw Error("Undefined response");
      }
    } catch (error) {
      console.log("Something went wrong in url generation", error);
    }
  };

  return (
    <>
      <div className="form-container">
        <Form>
          <Stack gap={2}>
            <Form.Label>
              <h2>Enter URL to shorten here</h2>
            </Form.Label>
            <Form.Control
              type="text"
              placeholder="Url to Shorten"
              onChange={handleInputChange}
              value={inputUrl}
            />

            <Button
              onClick={handleUrlGeneration}
              variant="primary"
              disabled={inputUrl.trim().length === 0}
            >
              Generate
            </Button>

            <Button
              onClick={clearInput}
              variant="secondary"
              disabled={inputUrl.trim().length === 0}
            >
              Clear
            </Button>
          </Stack>
        </Form>
      </div>
      {shortUrl !== "" && <DisplayShortUrl shortUrl={shortUrl} />}
    </>
  );
}
