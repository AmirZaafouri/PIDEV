<?php

namespace App\Entity;

use App\Repository\OffredemploiRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: OffredemploiRepository::class)]
class Offredemploi
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    #[Assert\Length(
        min: 2,
        max: 10,
        minMessage: 'le titre doit contenir au min {{limit}} caractère ',
        maxMessage: 'le titre doit contenir au max 10 caractère',
    )]
    private ?string $titre = null;

    #[ORM\Column]
    #[Assert\Length(
        min: 3,
        max: 8,
        minMessage: 'salaire doit contenir au min 3 caractère ',
        maxMessage: 'salaire doit contenir au max 8 caractère',
    )]
    private ?int $salaire = null;

    #[ORM\Column(length: 255)]
    #[Assert\Length(
        min: 5,
        max: 15,
        minMessage: 'description doit contenir au min 5 caractère ',
        maxMessage: 'description doit contenir au max 15 caractère',
    )]
    private ?string $description = null;

    #[ORM\Column]
    #[Assert\Length(
        min: 1,
        max: 8,
        minMessage: 'idstudio doit contenir au min 1 caractère ',
        maxMessage: 'idstudio doit contenir au max 8 caractère',
    )]
    private ?int $idstudio = null;



    #[ORM\ManyToOne(inversedBy: 'Type')]
    private ?TypeOffre $type = null;





    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitre(): ?string
    {
        return $this->titre;
    }

    public function setTitre(string $titre): self
    {
        $this->titre = $titre;

        return $this;
    }

    public function getSalaire(): ?int
    {
        return $this->salaire;
    }

    public function setSalaire(int $salaire): self
    {
        $this->salaire = $salaire;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }


    public function getIdstudio(): ?int
    {
        return $this->idstudio;
    }

    public function setIdstudio(int $idstudio): self
    {
        $this->idstudio = $idstudio;

        return $this;
    }

    public function getType(): ?TypeOffre
    {
        return $this->type;
    }

    public function setType(?TypeOffre $type): self
    {
        $this->type = $type;

        return $this;
    }
}
