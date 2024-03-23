import { Grid } from "@mui/material";
import UrlInput from "../components/urlInput/urlInput";
import "./pageView.css";
import NavBar from "../components/NavBar/NavBar";

export default function PageView() {
  return (
    <div className="page-container">
      <Grid>
        <Grid item>
          <NavBar></NavBar>
        </Grid>
        <Grid item>
          <UrlInput></UrlInput>
        </Grid>
      </Grid>
    </div>
  );
}
