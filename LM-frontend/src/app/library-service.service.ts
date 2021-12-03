import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from './book';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LibraryServiceService {

  private libraryUrl: string;
  private userBorrowedBooks: string;
  private borrowUrl: string;
  private returnUrl: string;

  constructor(private http: HttpClient) {
    this.libraryUrl="http://localhost:8082/Library/book";
    this.userBorrowedBooks="http://localhost:8082/User/book";
    this.borrowUrl="http://localhost:8082/Library/book/borrow";
    this.returnUrl="http://localhost:8082/Library/book/return";
   }

   public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.libraryUrl);
  }

  public save(book: Book) {
    return this.http.post<Book>(this.libraryUrl, book);
  }

  public findBorrowedBooks(userId: Number) : Observable<Book[]>{
    return this.http.get<Book[]>(this.userBorrowedBooks+"/"+userId);
  }

  public borrow(bookId: string) {
    return this.http.post<Number>(this.borrowUrl+"/"+bookId,bookId);
  }

  public return(bookId: string) {
    return this.http.post<Number>(this.returnUrl+"/"+bookId,bookId);
  }


}
