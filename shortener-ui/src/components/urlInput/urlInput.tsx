import { Button, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import generateUrl from "../../api/apiCall";

export default function urlInput() {
  return (
    <Form>
      <Form.Label>Enter URL to shorten here</Form.Label>
      <Form.Control type="text" placeholder="Url to Shorten"></Form.Control>
      <Button onClick={generateUrl} variant="primary">
        Generate
      </Button>
    </Form>
  );
}
