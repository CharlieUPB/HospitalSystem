import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientCIModalComponent } from './patient-cimodal.component';

describe('PatientCIModalComponent', () => {
  let component: PatientCIModalComponent;
  let fixture: ComponentFixture<PatientCIModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientCIModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientCIModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
