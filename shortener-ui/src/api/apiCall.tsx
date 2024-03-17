import {
  API_BASE_URL,
  GENERATE_SHORT_URL_ENDPOINT,
} from "../constants/apiConstants";
import { GenerateUrlPayload } from "../interface/generateUrlPayload";
import { ShortUrlResponseData } from "../interface/shortUrlResponseData";

const createPostRequest = (payload: GenerateUrlPayload) => {
  return {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(payload),
  };
};
const generateUrl = async (originalUrl: string) => {
  try {
    const payload: GenerateUrlPayload = { originalUrl };
    const response = await fetch(
      API_BASE_URL + GENERATE_SHORT_URL_ENDPOINT,
      createPostRequest(payload)
    );

    if (!response.ok) {
      console.log("Something went wrong");
    }
    const responseData: ShortUrlResponseData = await response.json();
    console.log("RESPONSE DATA", responseData);
    return responseData;
  } catch (error) {
    console.log("In Catch");
  }
};

export default generateUrl;
