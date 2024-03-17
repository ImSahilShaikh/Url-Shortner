import { Nav } from "react-bootstrap";
import { ShortUrlProp } from "../../interface/shortUrlProp";
import { API_BASE_URL } from "../../constants/apiConstants";

export default function DisplayUrlDetails(props: ShortUrlProp) {
  const url = API_BASE_URL + props.shortUrl;
  return (
    <Nav.Link className="" href={url}>
      {url}
    </Nav.Link>
  );
}
