import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { LibraryServiceService } from '../library-service.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  
  books!: Book[];

  constructor(private libraryService: LibraryServiceService) { 
 
  }

  

  ngOnInit() {
    this.libraryService.findAll().subscribe(data=>{
      this.books=data;
    });
  }


  addToBorrow(id: string){
    this.libraryService.borrow(id).subscribe();
  }

}
