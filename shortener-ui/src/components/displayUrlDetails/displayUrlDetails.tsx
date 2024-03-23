import { ShortUrlProp } from "../../interface/shortUrlProp";
import { API_BASE_URL } from "../../constants/apiConstants";
import { Link } from "@mui/material";

export default function DisplayUrlDetails(props: ShortUrlProp) {
  const url = props.shortUrl === "" ? "" : API_BASE_URL + props.shortUrl;
  return (
    <Link underline="hover" className="url-details-container" href={url}>
      {url}
    </Link>
  );
}
