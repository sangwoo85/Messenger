import axios from 'axios';
import { BrowserRouter as Navigate } from "react-router-dom";

const server_url = window.location.protocol +"//"+ window.location.hostname+":8090";
const chatBasixAxios = axios.create({
    baseURL: server_url,
    timeout: 60000,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json'
    }
});

chatBasixAxios.interceptors.request.use(
    (config) => {
        //config.headers['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
        return config;
    },
    (error) => {    
        console.log(error);
        return Promise.reject(error);
    }
);

chatBasixAxios.interceptors.response.use(
    (response) => {
        return response;
    },(error) => {
        console.log(error);

        if(error.response?.status == 401){
            alert("로그인 후 이용해주세요.");
            Navigate("/login");
        }else if(error.response && error.response.data){
            alert(error.response.data.message);
        }
        return Promise.reject(error);
    }
);

export default chatBasixAxios;  