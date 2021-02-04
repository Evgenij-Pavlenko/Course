import {Component} from '@angular/core';

export interface Post {
  title: string;
  text: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  posts: Post[] = [
    {title: 'Title1', text: 'Text1'},
    {title: 'Title2', text: 'Text2'},
    {title: 'Titlez3', text: 'Text3'},
    {title: 'Заголовок', text: 'Text3'}
  ];

  search = '';
  searchField = 'title';

}
