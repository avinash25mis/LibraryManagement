import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { LibraryServiceService } from '../library-service.service';

@Component({
  selector: 'app-borrowed-books',
  templateUrl: './borrowed-books.component.html',
  styleUrls: ['./borrowed-books.component.css']
})
export class BorrowedBooksComponent implements OnInit {

  books!:Book[];
  constructor(private libraryService: LibraryServiceService) { }

  ngOnInit(): void {
     this.libraryService.findBorrowedBooks(1).subscribe(data=>{
       this.books=data;
     })
  }


  returnToLibrary(id: string){
    this.libraryService.return(id).subscribe();
  }

}
