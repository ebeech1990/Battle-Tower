# Battle-Tower

api https://github.com/PokeAPI/pokekotlin

Pokemon
  Gen 1 (no held items, status conditions) (using spatk and spdef instead of just spec)
    B(base stat) I(individual value) E(effort value, stat exp) L(level) N(nature)
  
    total and indv B
    attack, defense, special attack, special defense, speed
      Stat = floor(floor((2 * B + I + E) * L / 100 + 5) * N)
    hp
      Stat = floor((2 * B + I + E) * L / 100 + L + 10)
      
      example Butterfree
      
      Stat    Base  IV
      HP      60    28
      Atk     45    4
      Def     50    17
      Spatk   80    30
      Spdef   80    27
      Speed   70    31
      
      HP
        HP = floor((2 * 60 + 28 + 1) * 53 / 100 + 53 + 10)
        HP = floor(149 * 53 / 100 + 63)
        HP = floor(149 * 53 / 100 + 63)
        HP = floor(141.97)
        HP = 141

      Attack
        Attack = floor(floor((2 * 45 + 4 + 0) * 53 / 100 + 5) * 0.9)
        Attack = floor(floor(94 * 53 / 100 + 5) * 0.9)
        Attack = floor(floor(54.82) * 0.9)
        Attack = floor(54 * 0.9)
        Attack = floor(48.6)
        Attack = 48

      Defense
        Defense = floor(floor((2 * 50 + 17 + 0) * 53 / 100 + 5) * 1)
        Defense = floor(floor(117 * 53 / 100 + 5) * 1)
        Defense = floor(floor(67.01) * 1)
        Defense = floor(67 * 1)
        Defense = 67

      Special Attack
        Special Attack = floor(floor((2 * 80 + 30 + 63) * 53 / 100 + 5) * 1.1)
        Special Attack = floor(floor(253 * 53 / 100 + 5) * 1.1)
        Special Attack = floor(floor(139.09) * 1.1)
        Special Attack = floor(139 * 1.1)
        Special Attack = floor(152.9)
        Special Attack = 152

        Special Defense
          Special Defense = floor(floor((2 * 80 + 27 + 0) * 53 / 100 + 5) * 1)
          Special Defense = floor(floor(187 * 53 / 100 + 5) * 1)
          Special Defense = floor(floor(104.11) * 1)
          Special Defense = floor(104 * 1)
          Special Defense = 104

          Speed
            Speed = floor(floor((2 * 70 + 31 + 63) * 53 / 100 + 5) * 1)
            Speed = floor(floor(234 * 53 / 100 + 5) * 1)
            Speed = floor(floor(129.02) * 1)
            Speed = floor(129 * 1)
            Speed = 129
    
