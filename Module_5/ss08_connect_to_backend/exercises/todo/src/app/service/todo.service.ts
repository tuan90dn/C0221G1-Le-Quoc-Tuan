import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IToDo} from '../model/IToDo';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = 'http://jsonplaceholder.typicode.com/todos';

  constructor(private http: HttpClient) {
  }

  // @ts-ignore
  getTodos(count = 10): Observable<IToDo[]> {
    return this.http.get<IToDo[]>(this.API_URL).pipe(map(data => data.filter((todo, i) => i < count)));
  }

  updateTodo(todo: IToDo): Observable<IToDo> {
    return this.http.patch<IToDo>(
      `${this.API_URL}/${todo.id}`, todo);
  }
  deleteTodo(id: number): Observable<any> {
    return this .http.delete(
      `${this.API_URL}/${id}`
    ) ;
  }
  createTodo( todo: Partial<IToDo> ): Observable<IToDo> {
    return this.http.post<IToDo>(this.API_URL, todo);
  }
}
