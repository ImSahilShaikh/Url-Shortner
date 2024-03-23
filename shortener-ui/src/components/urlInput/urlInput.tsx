import { Button, Form, Stack, Row, Col } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import generateUrl from "../../api/apiCall";
import React, { useState } from "react";
import { ShortUrlResponseData } from "../../interface/shortUrlResponseData";
import DisplayShortUrl from "../DisplayUrlDetails/DisplayUrlDetails";

export default function UrlInput() {
  const [inputUrl, setInputUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");
  const [loading, setLoading] = useState(false);

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputUrl(event.target.value);
  };

  const clearInput = () => {
    setInputUrl("");
  };

  const handleUrlGeneration = async () => {
    setLoading(true);
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
      setShortUrl("Error Url 12341234");
      console.log("Something went wrong in url generation", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <Row className="justify-content-center align-items-center vh-100">
      <Col md={6} className="mx-auto text-center">
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
              disabled={inputUrl.trim().length === 0 || loading}
            >
              Generate
            </Button>

            <Button
              onClick={clearInput}
              variant="secondary"
              disabled={inputUrl.trim().length === 0 || loading}
            >
              Clear
            </Button>
          </Stack>
        </Form>
        <div className="short-url-details">
          {shortUrl && <DisplayShortUrl shortUrl={shortUrl} />}
        </div>
      </Col>
    </Row>
  );
}
