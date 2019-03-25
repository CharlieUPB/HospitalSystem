import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorWorkStationComponent } from './doctor-work-station.component';

describe('DoctorWorkStationComponent', () => {
  let component: DoctorWorkStationComponent;
  let fixture: ComponentFixture<DoctorWorkStationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorWorkStationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorWorkStationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
