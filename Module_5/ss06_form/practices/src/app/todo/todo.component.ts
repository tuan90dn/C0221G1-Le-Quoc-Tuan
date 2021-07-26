import { Component, OnInit } from '@angular/core';
import {IToDo} from '../model/IToDo';
import {FormControl} from '@angular/forms';

// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  todos: IToDo[] = [];
  content = new FormControl();
  constructor() { }

  ngOnInit(): void {
  }
  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }
  change() {
    const value = this.content.value;
    if (value) {
      const todo: IToDo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

}
