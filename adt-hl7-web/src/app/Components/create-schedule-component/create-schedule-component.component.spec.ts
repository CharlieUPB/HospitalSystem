import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateScheduleComponentComponent } from './create-schedule-component.component';

describe('CreateScheduleComponentComponent', () => {
  let component: CreateScheduleComponentComponent;
  let fixture: ComponentFixture<CreateScheduleComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateScheduleComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateScheduleComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
