import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
    form: FormGroup;

    ngOnInit(): void {
        this.form = new FormGroup({
            email: new FormControl('', [
                Validators.email,
                Validators.required]),
            password: new FormControl(null, [
                Validators.required,
                Validators.minLength(3)]),
            address: new FormGroup({
                country: new FormControl('ua'),
                city: new FormControl('Kyiv', Validators.required)
            }),
            skills: new FormArray([])
        });
    }


    submit() {
        if (this.form.valid) {
            console.log('Form: ', this.form);
            const formData = this.form.value;
            console.log('form data: ', formData);
        }
    }

    setCapital() {
        const cityMap = {
            ru: 'Moscow',
            ua: 'Kyiv',
            by: 'Minsk'
        };
        const cityKey = this.form.get('address').get('country').value;
        const city = cityMap[cityKey];
        this.form.patchValue({
            address: {city}
        });
    }

    addSkill() {
        const control = new FormControl('', Validators.required);
        // (<FormArray> this.form.get('skills')).push;
        (this.form.get('skills') as FormArray).push(control);
    }
}
