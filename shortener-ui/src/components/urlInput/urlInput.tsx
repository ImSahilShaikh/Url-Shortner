import generateUrl from "../../api/apiCall";
import React, { useState } from "react";
import { ShortUrlResponseData } from "../../interface/shortUrlResponseData";
import DisplayUrlDetails from "../displayUrlDetails/displayUrlDetails";
import TextField from "@mui/material/TextField/TextField";
import Button from "@mui/material/Button/Button";
import { Container, Grid } from "@mui/material";

import "./urlInput.css";

export default function UrlInput() {
  const [inputUrl, setInputUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");
  const [loading, setLoading] = useState(false);

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputUrl(event.target.value);
  };

  const clearInput = () => {
    setInputUrl("");
    setShortUrl("");
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
    <Grid
      container
      justifyContent="center"
      alignItems="center"
      className="input-container"
    >
      <Container maxWidth="sm">
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              fullWidth
              id="filled-basic"
              label="Enter URL to Shorten"
              onChange={handleInputChange}
              value={inputUrl}
              variant="filled"
            />
          </Grid>

          <Grid item xs={6}>
            <Button
              onClick={clearInput}
              variant="contained"
              color="error"
              disabled={inputUrl.trim().length === 0 || loading}
            >
              Cancel
            </Button>
          </Grid>

          <Grid item container justifyContent="flex-end" xs={6}>
            <Button
              onClick={handleUrlGeneration}
              variant="contained"
              disabled={inputUrl.trim().length === 0 || loading}
            >
              Generate
            </Button>
          </Grid>
          <Grid item xs={6}>
            <div className="short-url-details">
              {<DisplayUrlDetails shortUrl={shortUrl} />}
            </div>
          </Grid>
        </Grid>
      </Container>
    </Grid>
  );
}
