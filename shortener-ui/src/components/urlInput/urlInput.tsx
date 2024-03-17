import { Button, Form, Stack } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import generateUrl from "../../api/apiCall";
import React, { useState } from "react";
import { ShortUrlResponseData } from "../../interface/shortUrlResponseData";
import DisplayShortUrl from "../displayUrlDetails/displayUrlDetails";

export default function UrlInput() {
  const [inputUrl, setInputUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputUrl(event.target.value);
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
            <Form.Label>Enter URL to shorten here</Form.Label>
            <Form.Control
              type="text"
              placeholder="Url to Shorten"
              onChange={handleInputChange}
              value={inputUrl}
            ></Form.Control>
            <Button onClick={handleUrlGeneration} variant="primary">
              Generate
            </Button>
          </Stack>
        </Form>
        <div className="display-container">
          {shortUrl !== "" && <DisplayShortUrl shortUrl={shortUrl} />}
        </div>
      </div>
    </>
  );
}
