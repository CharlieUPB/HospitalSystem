import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeriveRadiographyComponent } from './derive-radiography.component';

describe('DeriveRadiographyComponent', () => {
  let component: DeriveRadiographyComponent;
  let fixture: ComponentFixture<DeriveRadiographyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeriveRadiographyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeriveRadiographyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
