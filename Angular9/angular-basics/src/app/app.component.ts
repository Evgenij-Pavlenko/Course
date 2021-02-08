import {Component} from '@angular/core';
import {AppCounterService} from './services/app-counter.service';
import {LocalCounterService} from './services/local-counter.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [LocalCounterService]
})
export class AppComponent {
  appCounterService: AppCounterService;
  localCounterService: LocalCounterService;

  constructor(
    appCounterService: AppCounterService,
    localCounterService: LocalCounterService) {
    this.appCounterService = appCounterService;
    this.localCounterService = localCounterService;
  }

}
