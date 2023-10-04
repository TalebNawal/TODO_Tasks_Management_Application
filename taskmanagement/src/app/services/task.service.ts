import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { ITask, ITaskTypeOption, ITypePercentage } from '../interface/task.interface';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient:HttpClient) { }

  getTaskList(): Observable<Array<ITask>> {
    return this.httpClient
      .get<ITask[]>('http://localhost:8085/api/v1/task')
      .pipe(map((d: Array<ITask>) => d));
  }
  postTaskList(task: ITask): Observable<ITask> {
    return this.httpClient
      .post('http://localhost:8085/api/v1/task', task)
      .pipe(map((d: Object) => d as ITask));
  }
  updateTask(task: ITask, id: string): Observable<ITask> {
    return this.httpClient
      .put(`http://localhost:8085/api/v1/task/${id}`, task)
      .pipe(map((d: Object) => d as ITask));
  }
  deleteTask(id: string) {
    return this.httpClient.delete(`http://localhost:8085/api/v1/task/${id}`);
  }

  getTaskById(id: string): Observable<ITask> {
    return this.httpClient
      .get(`http://localhost:8085/api/v1/task/${id}`)
      .pipe(map((d: Object) => d as ITask));
  }

  getTypePercentage(): Observable<Array<ITypePercentage>> {
    return this.httpClient
      .get<ITypePercentage[]>(`http://localhost:8085/api/v1/task/vData/percentcounttype`)
      .pipe(map((d: Array<ITypePercentage>) => d));
  }

  getTypeOptions(): Array<ITaskTypeOption> {
    return [{ type: 'done' }, { type: 'todo' }, { type: 'pending' }];
  }
}



