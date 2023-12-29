import axios from "axios";
const http = axios.create(
    {
        baseURL: "http://localhost:8080/api/books",
        headers:{
            "Content-Type" : "application/json"
        }
    }
 );
 export default http;