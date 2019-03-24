import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeriveLaboratoryComponent } from './derive-laboratory.component';

describe('DeriveLaboratoryComponent', () => {
  let component: DeriveLaboratoryComponent;
  let fixture: ComponentFixture<DeriveLaboratoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeriveLaboratoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeriveLaboratoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
