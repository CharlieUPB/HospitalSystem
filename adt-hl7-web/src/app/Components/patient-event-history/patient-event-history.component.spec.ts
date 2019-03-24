import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientEventHistoryComponent } from './patient-event-history.component';

describe('PatientEventHistoryComponent', () => {
  let component: PatientEventHistoryComponent;
  let fixture: ComponentFixture<PatientEventHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientEventHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientEventHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
