package com.list;

public class LinkedList {

	private int size;
	
	private Node head;//ͷ�ڵ�
	
	Node current; //��ǰ�ڵ�
	
	public LinkedList(){
		this.head = current = new Node(null);
		this.size = 0;
	}
	
	//���Ԫ��
	private boolean add(Object object){
		addAfter(object);
		size++;
		return true;
	}
	
	//��ָ��λ�����Ԫ��
	private boolean add(int index,Object object) throws Exception{
		index(index - 1);
		current.nextNode = new Node(object,current.nextNode.nextNode);
		size++;
		return true;
	}
	
	//��ͷ�����Ԫ��
	private boolean addFirst(Object object){
		Node node = new Node(object,null);
		current = head.nextNode;
		head.nextNode = node;
		node.nextNode = current;
		size++;
		return true;
	}
	
	//��β�����Ԫ��
	private boolean addLast(Object object){
		add(object);
		return true;
	}
	
	//��ȡĳ��Ԫ��
	private Object get(int index) throws Exception{
		index(index);
		return current.object;
	}
	
	//�Ƴ�ĳ��Ԫ��
	private  Object remove(int index) throws Exception{
		
		if (index == size - 1){
			Object object = removeLast();
			return object;
		}
		index(index - 1);
		Object object = current.nextNode.object;
		
		current.nextNode = current.nextNode.nextNode;
		size--;
		return object;
	}
	
	private Object removeFirst(){
		Object object = null;
		if (size > 0){
			current = head.nextNode;
			object = current.object;
			head.nextNode = head.nextNode.nextNode;
			size--;
		}
		return object;
	}
	
	private Object removeLast() throws Exception{
		Object object = null;
		if (size > 0){
			int j = 0;
			current = head.nextNode;
			
			while (current != null){
				current = current.nextNode;
				j++;
			}
			index(j - 1);
			object = current.nextNode.object;
			current.nextNode = null;
			size--;
		}
		return object;
	}
	private void index (int index) throws Exception{
		
		if (index < -1 || index > size){
			
			throw new Exception("��������");
		}
		
		if (index == -1){
			return;
		}
		current = head.nextNode;
		int j = 0;
		while (current != null && j < index){
			current = current.nextNode;
			j++;
		}
	}
	
	
	private void addAfter(Object object){
		
		if (head.nextNode == null){
			
			Node newNode = new Node(object,null);
		}else{
			current = head.nextNode;
			while (current.nextNode == null){
				current = current.nextNode;
			}
			current.setNode(new Node(object,null));
		}
		
		
	}
	
	
	
	
	private static class Node{
		
		Object object;
		
		Node nextNode;
		
		//ͷ�ڵ�Ĺ��췽��
		Node (Node nextNode){
			this.nextNode = nextNode;
		}
		
		//��ͷ�ڵ�Ĺ��췽��
		Node (Object object, Node nextNode){
			this.nextNode = nextNode;
			this.object = object;
		}
		
		private void setNode(Node node){
			this.nextNode = node;
		}
		
	}
	
	
}
