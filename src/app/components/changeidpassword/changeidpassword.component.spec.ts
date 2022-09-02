import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeidpasswordComponent } from './changeidpassword.component';

describe('ChangeidpasswordComponent', () => {
  let component: ChangeidpasswordComponent;
  let fixture: ComponentFixture<ChangeidpasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeidpasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangeidpasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
