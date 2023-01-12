import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CoursModel} from "../Model/CoursModel";
import {Observable} from "rxjs";
import {CrossOrigin} from "@angular-devkit/build-angular";

@Component({
  selector: 'app-coursModel-list',
  templateUrl: './coursModel-list.component.html',
  styleUrls: ['./coursModel-list.component.css']
})

export class CoursModelListComponent implements OnInit {

  private URL_COURS = 'jdbc:postgresql://dumbo.db.elephantsql.com/jlkhvktz';
  private USERNAME_COURS = 'jlkhvktz';
  private PASSWORD_COURS = 'BzNqeGNuN24Nc422ZT9CGbUyxbZZHBgq';

    getCoursByDate(): Observable<CoursModel["date"]> {
    const url = `${this.URL_COURS}/coursModel`;
    const username = `${this.USERNAME_COURS}/unsername`;
    const password = `${this.PASSWORD_COURS}/password`;
    // @ts-ignore
      return this.httpClient.get<CoursModel["date"]>(url, username, password);
  }

  coursModelList: string;

  constructor(private readonly httpClient: HttpClient) { }
  ngOnInit(): void {
    this.getCoursByDate().pipe().subscribe(value => { this.coursModelList = value;});
  }

}
