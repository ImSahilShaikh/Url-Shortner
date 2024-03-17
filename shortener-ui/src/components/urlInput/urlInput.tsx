import { Button, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import generateUrl from "../../api/apiCall";
import React, { useState } from "react";
import { ShortUrlResponseData } from "../../interface/shortUrlResponseData";

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
    <Form>
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
      {shortUrl !== "" && (
        <Form.Label>Shortened Url is : {shortUrl}</Form.Label>
      )}
    </Form>
  );
}
