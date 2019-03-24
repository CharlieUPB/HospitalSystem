import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgendamientoRegisterComponent } from './agendamiento-register.component';

describe('AgendamientoRegisterComponent', () => {
  let component: AgendamientoRegisterComponent;
  let fixture: ComponentFixture<AgendamientoRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgendamientoRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgendamientoRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
