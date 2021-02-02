import {Directive, ElementRef, HostListener, Renderer2} from '@angular/core';

@Directive({
  selector: '[appStyle]'
})
export class StyleDirective {
  constructor(private elRef: ElementRef, private renderer: Renderer2) {
    // elRef.nativeElement.style.color = 'red';
  }

  @HostListener('click', ['$event']) onClick(event: Event) {
    console.log(event.currentTarget);
  }

  @HostListener('mouseenter') onEnter() {
    this.renderer.setStyle(this.elRef.nativeElement, 'color', 'blue');
  }

  @HostListener('mouseleave') onLeave() {
    this.renderer.setStyle(this.elRef.nativeElement, 'color', null);
  }
}
