import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientRegisterComponentComponent } from './patient-register-component.component';

describe('PatientRegisterComponentComponent', () => {
  let component: PatientRegisterComponentComponent;
  let fixture: ComponentFixture<PatientRegisterComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientRegisterComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientRegisterComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
