import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CommentModel} from "../../model/commentmodel";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) {
  }

  findCommentsByTaskId(id: string): Observable<CommentModel[]> {
    return this.http.get<CommentModel[]>('/api/comments/taskId/' + id);
  }

  saveComment(comment: CommentModel): Observable<CommentModel> {
    return this.http.post<CommentModel>("/api/comments", comment);
  }
}
