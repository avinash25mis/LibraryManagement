import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { LibraryServiceService } from '../library-service.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
 book: Book;
  constructor(private route:ActivatedRoute, private router:Router,private libraryService: LibraryServiceService) {
    this.book=new Book();
   }

  ngOnInit(): void {
  }
  onSubmit() {
    debugger;
    this.libraryService.save(this.book).subscribe(data=>{
     console.log("see");
    }
  
    
    );
  }

  gotoBookList() {
    this.router.navigate(['/bookList']);
  }

  

}
