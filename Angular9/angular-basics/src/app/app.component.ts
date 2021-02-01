import {Component, OnInit} from '@angular/core';

export interface Post {
  title: string;
  text: string;
  id?: number;
}

export interface News {
  id?: number;
  title: string;
  text: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  posts: Post[] = [
    {title: 'Title 1', text: 'text 1 fgfgfvfvfvfvfvvfv', id: 1}
    // {title: 'Title 2', text: 'text 2 fgfgfvfvfvfvfvvfv', id: 2}
  ];

  ngOnInit(): void {
    setTimeout(() => {
      console.log('Timeout');
      this.posts[0] = {
        title: 'Changed!',
        text: 'changed 2',
        id: 1
      };
    }, 4000);
  }

  updatePosts(post: Post) {
    this.posts.unshift(post);
    // console.log('New post', post);
  }

  removePost(id: number) {
    this.posts = this.posts.filter(p => p.id !== id);
  }
}
