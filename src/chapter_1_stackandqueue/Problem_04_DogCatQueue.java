package chapter_1_stackandqueue;


import java.util.LinkedList;
import java.util.Queue;

// https://www.nowcoder.com/practice/8a7e04cff6a54b7095b94261d78108f5?tpId=101&tqId=33168&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E7%8C%AB
public class Problem_04_DogCatQueue {

	public static class Pet {
		private String petType;

		public Pet(String type) {
			this.petType = type;
		}

		public String getPetType() {
			return petType;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}

	public static class PetEnterQueue {
		private Pet pet;
		private int count;

		public PetEnterQueue(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return pet;
		}

		public int getCount() {
			return count;
		}
	}

	public static class DogCatQueue {

		Queue<PetEnterQueue> dogQueue;
		Queue<PetEnterQueue> catQueue;
		int count;

		public DogCatQueue() {
			this.dogQueue = new LinkedList<>();
			this.catQueue = new LinkedList<>();
			this.count = 0;
		}

		public void add(Pet pet) {
			if ("dog".equals(pet.getPetType())) {
				dogQueue.offer(new PetEnterQueue(pet, count++));
			} else if ("cat".equals(pet.getPetType())) {
				catQueue.offer(new PetEnterQueue(pet, count++));
			}
		}

		public Pet pollAll() {
			if (dogQueue.isEmpty() && catQueue.isEmpty()) {
				throw new RuntimeException("empty");
			}

			if (dogQueue.isEmpty()) {
				return catQueue.poll().getPet();
			}

			if (catQueue.isEmpty()) {
				return dogQueue.poll().getPet();
			}

			if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
				return dogQueue.poll().getPet();
			} else {
				return catQueue.poll().getPet();
			}
		}

		public Dog pollDog() {
			if (dogQueue.isEmpty()) {
				throw new RuntimeException("empty");
			}
			return (Dog) dogQueue.poll().getPet();
		}

		public Cat pollCat() {
			if (catQueue.isEmpty()) {
				throw new RuntimeException("empty");
			}
			return (Cat) catQueue.poll().getPet();
		}

		public boolean isEmpty() {
			return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
		}

		public boolean isDogQueueEmpty() {
			return this.dogQueue.isEmpty();
		}

		public boolean isCatQueueEmpty() {
			return this.catQueue.isEmpty();
		}
	}

	public static void main(String[] args) {
		DogCatQueue test = new DogCatQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		while (!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}
	}

}
