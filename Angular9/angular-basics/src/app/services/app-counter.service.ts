import {Injectable} from '@angular/core';
import {LogService} from './log.service';

@Injectable({
  providedIn: 'root'
})
export class AppCounterService {
  counter = 0;
  logService: LogService;

  constructor(logService: LogService) {
    this.logService = logService;
  }

  increase() {
    this.logService.log('increase counter...');
    this.counter++;
  }

  decrease() {
    this.logService.log('decrease counter...');
    this.counter--;
  }
}
