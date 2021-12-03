import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookFormComponent } from './book-form/book-form.component';
import { BookListComponent } from './book-list/book-list.component';
import { BorrowedBooksComponent } from './borrowed-books/borrowed-books.component';

const routes: Routes = [
  { path: 'bookList', component: BookListComponent },
  { path: 'addBook', component: BookFormComponent },
  { path: 'borrowedBooks', component: BorrowedBooksComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
