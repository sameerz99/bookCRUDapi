import React, { useEffect, useState } from 'react'
import bookService from '../services/bookService';

function BookById() {
    const [bookId, setBookId] = useState('');
    const [bookInfo, setBookInfo] = useState(null);
    const [error, setError] = useState(null);
    
    const handleIdChange = (e) => {
        setBookId(e.target.value)
    }
     const handleSearch = ()=>{
        fetchBookInfo();
     }
   

      const fetchBookInfo = async () => {
        try {
          if (bookId !== '') {
            const response = await bookService.getBookInfoById(bookId);
            setBookInfo(response.data);
            console.log(response.data);
            setError(null);
          } else {
              setError("Error fetching book by id");
            setBookInfo(null);
          }
        } catch (error) {
          console.error('Error fetching book by id', error);
        }
      };
    
  return (
    <>
    <div>
        <h1>Book Details</h1>
        <label htmlFor='bookId'> Enter book ID:</label>
        <input
        type='number'
        id='bookId'
        value={bookId}
        onChange={handleIdChange}
        />
        <button onClick={handleSearch}>Search</button>
        {error && <p>{error}</p>}

        {bookInfo && (
            <div>
                <h2>Book Information</h2>
                <p>ID: {bookInfo.id}</p>
                <p>Name: {bookInfo.name}</p>
                <p>Author: {bookInfo.author}</p>
                <p>price: {bookInfo.price}</p>
            </div>
        )}
    </div>
    </>
  )
}

export default BookById