import {
  API_BASE_URL,
  GENERATE_SHORT_URL_ENDPOINT,
} from "../constants/apiConstans";

const generateUrl = async () => {
  try {
    const response = await fetch(API_BASE_URL + GENERATE_SHORT_URL_ENDPOINT);
    console.log(response);
  } catch (error) {
    console.log("asdasd");
  }
};

export default generateUrl;
