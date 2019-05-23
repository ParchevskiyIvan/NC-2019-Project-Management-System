import {Component, OnInit} from '@angular/core';
import {CommentModel} from "../../../../model/commentmodel";
import {AuthService} from "../../../../service/auth/auth.service";
import {CommentService} from "../../../../service/comment/comment.service";
import {TaskModel} from "../../../../model/taskmodel";
import {TaskService} from "../../../../service/task/task.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  newComment: CommentModel = new CommentModel();
  comments: CommentModel[];
  taskId: string;
  public commentAdding = false;
  public task: TaskModel;
  formControl: FormGroup;

  constructor(private auth: AuthService, private commentService: CommentService, private taskService: TaskService,
              private activatedRoute: ActivatedRoute, private router: Router, private fb: FormBuilder) {
  }

  ngOnInit() {
    if (this.auth.user == null) {
    } else {
      this.loadTask();
      this.loadComments();
      this.initReactForm();
    }
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      comment: ['', Validators.required]
    });
  }

  private getId(): void {
    this.activatedRoute.params.subscribe(params => {
      this.taskId = params['taskId'];
    });
  }

  private loadTask(): void {
    this.getId();
    this.taskService.getTaskById(this.taskId).subscribe(task => {
      this.task = task as TaskModel;
    });
  }

  private addComment() {
    this.newComment.user = this.auth.user;
    this.newComment.task = this.task;
    this.commentService.saveComment(this.newComment).subscribe(() => {
      this.newComment = new CommentModel();
    })
  }

  private commentAddMode() {
    if (this.commentAdding == false) {
      this.commentAdding = true;
      this.ngOnInit();
    } else if (this.commentAdding == true) {
      this.addComment();
      this.ngOnInit();
      this.commentAdding = false;
    }
  }

  private loadComments(): void {
    this.commentService.findCommentsByTaskId(this.taskId).subscribe(comments => {
      this.comments = comments as CommentModel[];
    })

  }
}
