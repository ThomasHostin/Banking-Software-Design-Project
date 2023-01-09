import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageConnectedComponent } from './home-page-connected.component';

describe('HomePageConnectedComponent', () => {
  let component: HomePageConnectedComponent;
  let fixture: ComponentFixture<HomePageConnectedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomePageConnectedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomePageConnectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
