import { Component, OnInit } from '@angular/core';
import { ChartConfiguration, Color } from 'chart.js';
import { TaskService } from 'src/app/services/task.service';
import { ITypePercentage } from 'src/app/interface/task.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public doughnutChartOptions: ChartConfiguration<'doughnut'>['options'] = {
    responsive: true,
  };
  public doughnutChartLabels: string[] = [];
  public doughnutChartDatasets: ChartConfiguration<'doughnut'>['data']['datasets'] = [
    { data: [], label: 'Series A' },
  ];
  public doughnutChartColor: Color[] = ['#f68059', '#ffbf3a', '#4e3dc8'];
  public typeData: ITypePercentage[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.getTypePercentage();
  }

  getTypePercentage() {
    this.taskService.getTypePercentage().subscribe(
      (data: ITypePercentage[]) => {
        this.typeData = data;
        this.doughnutChartDatasets[0].data = data.map(type => type.count);
        this.doughnutChartLabels = data.map(type => type.type);
      },
      (error) => {
        console.error(error);
      }
    );
  }
  refreshEmitter() {
    this.getTypePercentage();
  }
}
