SELECT COUNT(*) FROM film WHERE length >
(
	SELECT AVG(length) FROM film
);



SELECT COUNT(*) FROM film WHERE rental_rate = 
(
	SELECT MAX(rental_rate) FROM film
);



SELECT COUNT(*) FROM film WHERE rental_rate = 
(
	SELECT MIN(rental_rate) FROM film
)
AND replacement_cost = 
(
	SELECT MIN(replacement_cost) FROM film
);



SELECT customer.customer_id,customer.first_name, COUNT(payment_id) FROM payment 
JOIN customer ON customer.customer_id = payment.customer_id
GROUP BY customer.customer_id, customer.first_name
ORDER BY COUNT(payment_id) DESC;