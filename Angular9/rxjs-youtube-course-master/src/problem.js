import {interval} from 'rxjs'
import {filter, map} from 'rxjs/operators'

const btn = document.getElementById('interval')
const rxjsBtn = document.getElementById('rxjs')
const display = document.querySelector('#problem .result')

const people = [
    {name: 'Vladilen', age: 25},
    {name: 'Elena', age: 17},
    {name: 'Ivan', age: 18},
    {name: 'Igor', age: 14},
    {name: 'Lisa', age: 32},
    {name: 'Irina', age: 23},
    {name: 'Oleg', age: 20}
]

rxjsBtn.addEventListener('click', () => {
    interval(1000)
        .pipe(
            filter(v => people[v] >= 18),
            map(v => people[v].name)
        )
        .subscribe(res => {
            display.textContent = res
        })
})
