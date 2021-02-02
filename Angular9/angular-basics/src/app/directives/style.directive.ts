import {Directive, ElementRef, HostListener, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appStyle]'
})
export class StyleDirective {

  @Input('appStyle') color: string;
  @Input() dStyles: {border?: string, fontWeight?: string, borderRadius?: string};

  constructor(private elRef: ElementRef, private renderer: Renderer2) {
    // elRef.nativeElement.style.color = 'red';
  }

  @HostListener('click', ['$event']) onClick(event: Event) {
    console.log(event.currentTarget);
  }

  @HostListener('mouseenter') onEnter() {
    this.renderer.setStyle(this.elRef.nativeElement, 'color', this.color);
    this.renderer.setStyle(this.elRef.nativeElement, 'fontWeight', this.dStyles.fontWeight);
    this.renderer.setStyle(this.elRef.nativeElement, 'border', this.dStyles.border);
    this.renderer.setStyle(this.elRef.nativeElement, 'borderRadius', this.dStyles.borderRadius);
  }

  @HostListener('mouseleave') onLeave() {
    this.renderer.setStyle(this.elRef.nativeElement, 'color', null);
    this.renderer.setStyle(this.elRef.nativeElement, 'fontWeight', null);
    this.renderer.setStyle(this.elRef.nativeElement, 'border', null);
    this.renderer.setStyle(this.elRef.nativeElement, 'borderRadius', null);
  }
}
