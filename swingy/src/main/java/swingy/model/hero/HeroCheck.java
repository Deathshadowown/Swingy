/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   HeroCheck.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/24 15:58:24 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/24 15:58:24 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import swingy.model.hero.Hero;

public class HeroCheck{
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	public static boolean nameCheck(Hero player) {
		Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(player);
		if (constraintViolations.size() != 0 ) {
			for (ConstraintViolation<Hero> constraintViolation : constraintViolations) {
				System.err.println(constraintViolation.getMessage());
			}
			return true;
		}
		return false;
	}
}