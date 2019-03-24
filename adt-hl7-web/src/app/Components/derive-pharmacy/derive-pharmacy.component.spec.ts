import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DerivePharmacyComponent } from './derive-pharmacy.component';

describe('DerivePharmacyComponent', () => {
  let component: DerivePharmacyComponent;
  let fixture: ComponentFixture<DerivePharmacyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DerivePharmacyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DerivePharmacyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
