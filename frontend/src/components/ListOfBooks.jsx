import axios from 'axios';
import React, { useEffect, useState } from 'react';
import bookService from '../services/bookService';

function ListOfBooks() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    bookService.getAllBook()
        .then(response =>{
          console.log(response.data);
          setBooks(response.data);
        })
        .catch(error => console.error("error fetching data",error));
  }, []);

  return (
    <>
      <div>
        <h1>List of Books</h1>
        <ul>
          {books.map(book => (
            <li key={book.id}>
              {book.name}
            </li>
          ))}
        </ul>
      </div>

  
    </>
  );
}

export default ListOfBooks;
