import http from "../http-common";

class BookService{
    getAllBook(){
        return http.get("/");
    }
    getBookInfoById(id){
        return http.get(`/${id}`);
    }
    saveBookInfo(data){
        return http.post("/save",data);
    }
    updateBookInfo(id,data){
        return http.put(`/${id}`,data);
    }
    deleteBookInfoById(id){
        return http.delete(`/${id}`);
    }
    
}

export default new BookService();