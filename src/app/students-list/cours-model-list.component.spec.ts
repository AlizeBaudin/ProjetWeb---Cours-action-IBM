import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CoursModelListComponent  } from './cours-model-list.component';

describe('CoursModelListComponent ', () => {
  let component: CoursModelListComponent ;
  let fixture: ComponentFixture<CoursModelListComponent >;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursModelListComponent  ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursModelListComponent );
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
