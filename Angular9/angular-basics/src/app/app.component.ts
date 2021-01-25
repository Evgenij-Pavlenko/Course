import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-basics';
  number = 37;
  img = 'https://cdn-front.kwork.ru/pics/t3/92/4037249-1578731692.jpg';
  inputValue = '';

  constructor() {
    setTimeout(() => {
      this.img = 'https://pluralsight2.imgix.net/paths/images/angular-14a0f6532f.png';
    }, 2000);
  }

  onInput(event: KeyboardEvent) {
    console.log('Event:', event);
    this.inputValue = ( <HTMLInputElement> event.target).value;
  }

  onClick() {
    console.log('Click!');
  }

  onBlur(str: string) {
    this.inputValue = str;
  }
}
